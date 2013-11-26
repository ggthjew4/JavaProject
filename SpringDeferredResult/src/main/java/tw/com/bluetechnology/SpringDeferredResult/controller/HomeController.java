package tw.com.bluetechnology.SpringDeferredResult.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import tw.com.bluetechnology.SpringDeferredResult.vo.Message;

@Controller
public class HomeController {
	private final SimpleDateFormat						sdf				= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final Map<String, DeferredResult<Message>>	chatRequests	= new ConcurrentHashMap<String, DeferredResult<Message>>();

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String name, HttpSession session) {
		session.setAttribute("user", name);
		Message msg = new Message();
		msg.setUser("系統");
		msg.setDate(sdf.format(new Date()));
		msg.setContent(name + "已加入聊天");
		// 通知所有用戶有人進入聊天室
		processMessage(msg);
		return "room";
	}

	@RequestMapping(value = "/getMessages", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public DeferredResult<Message> getMessages(HttpSession session) {
		final String user = (String) session.getAttribute("user");
		DeferredResult<Message> dr = new DeferredResult<Message>(0);
		if (null == user) {
			return dr;
		}
		else {
			dr.onCompletion(new Runnable() {
				@Override
				public void run() {
					chatRequests.remove(user);
				}
			});
			chatRequests.put(user, dr);
			return dr;
		}
	}

	/**
	 * @return Map<String, String>
	 */
	@RequestMapping(value = "/setMessage", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Map<String, String> setMessage(HttpSession session, @RequestParam String content) {
		Message msg = new Message();
		msg.setContent(content);
		msg.setDate(sdf.format(new Date()));
		msg.setUser((String) session.getAttribute("user"));
		// 发布消息给所有用户
		processMessage(msg);
		Map<String, String> map = new HashMap<String, String>(1);
		map.put("success", "true");
		return map;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> logout(HttpSession session) {
		Message msg = new Message();
		String user = (String) session.getAttribute("user");
		msg.setContent("已悄悄的離開了");
		msg.setDate(sdf.format(new Date()));
		msg.setUser(user);
		chatRequests.remove(user);
		processMessage(msg);
		Map<String, String> map = new HashMap<String, String>(1);
		map.put("success", "true");
		return map;
	}

	private void processMessage(Message msg) {
		Set<String> keys = chatRequests.keySet();
		for (String key : keys) {
			chatRequests.get(key).setResult(msg);
		}
	}
}
