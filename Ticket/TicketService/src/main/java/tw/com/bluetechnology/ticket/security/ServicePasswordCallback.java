package tw.com.bluetechnology.ticket.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.cxf.common.util.StringUtils;
import org.apache.ws.security.WSPasswordCallback;

/**
 * WebService Security Callback程式 驗證 clinet SOAP 內容資料是否符合權限
 * 
 * @see CallbackHandler
 * @author kerrigan
 */
public class ServicePasswordCallback implements CallbackHandler {
	/**
	 * 存放使用者驗證資料{@link Map}
	 */
	private Map<String, String>	authenticatedData	= new HashMap<String, String>();

	public ServicePasswordCallback() {
		authenticatedData.put("userName", "kerrigan");
		authenticatedData.put("password", "joespassword");
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		final String username = pc.getIdentifier();
		if (StringUtils.isEmpty(username) || !username.equals(authenticatedData.get("userName"))) {
			throw new IOException("wrong user");
		}
		else {
			pc.setPassword("joespassword");
		}
	}
}