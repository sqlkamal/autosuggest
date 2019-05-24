package test.amazon.api.modal;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

public class RESTTester {

	/* sending request and parameter in url itself */
	public String callAPIAutoSuggest(String product) {
		String result = null;
		String restURL_JSON = "https://completion.amazon.com/api/2017/suggestions?session-id=141-7522176-8063063&customer-id=&request-id=BF92DGNEH4WA9JR3574X&page-type=Gateway&lop=en_US&site-variant=desktop&client-info=amazon-search-ui&mid=ATVPDKIKX0DER&alias=aps&b2b=0&fresh=0&ks=32&prefix="
				+ product
				+ "+&event=onKeyPress&limit=11&fb=1&suggestion-type=KEYWORD&suggestion-type=WIDGET&_=1558654174520";
		HttpUriRequest request = new HttpGet(restURL_JSON);
		HttpResponse httpResponse = null;
		try {
			httpResponse = HttpClientBuilder.create().build().execute(request);
			result = EntityUtils.toString(httpResponse.getEntity());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		return result;
	}

}
