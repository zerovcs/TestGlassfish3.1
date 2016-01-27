/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package si.test.client;

import si.test.client.jsinterop.JsObject;
import si.test.client.jsinterop.JsonReturnObject;
import si.test.client.xhr.MyXMLHttpRequest.ResponseType;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.MyRequestBuilder;
import com.google.gwt.http.client.MyRequestBuilder.MyRequest;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;


//http://www.html5rocks.com/en/tutorials/workers/basics/#toc-inlineworkers-bloburis
//http://stackoverflow.com/questions/27442120/open-a-pdf-content-in-a-new-browser-tab



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Demo implements EntryPoint {
	private Button clickMeButton;
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();

		clickMeButton = new Button();
		rootPanel.add(clickMeButton);
		clickMeButton.setText("Click me!");
		clickMeButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) 
			{
//				DemoService.Util.getInstance().test("Sebi", new AsyncCallback<String>() 
//				{
//					@Override
//					public void onSuccess(String arg0) 
//					{
//						Window.alert(arg0);
//					}
//					
//					@Override
//					public void onFailure(Throwable arg0) 
//					{
//						Window.alert(arg0.getMessage());
//					}
//				});
		/*
		 * Primer kako vraèa default - text in potem convert to json
				RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, "ServletReturnJson");
				try 
				{
					RequestCallback requestCallback = new RequestCallback()
					{
						@Override
						public void onResponseReceived(Request request, Response response) 
						{
//							JsObject obj = JsonUtil.getJSON().parse(response.getText() + "aaa");
//							JsObject obj = JSON.parse(response.getText());
							JsObject obj = JsonUtil.parseJson(response.getText());
							if(obj != null)
							{
								JsonReturnObject jro = JsObject.cast(obj);
								Window.alert(jro.getX());
								Window.alert(response.getText());
							}
						}
						
						@Override
						public void onError(Request request, Throwable exception) 
						{
							Window.alert(exception.getMessage());
						}
					};
					builder.sendRequest(null, requestCallback);
				
				}
				catch (RequestException e) 
				{
					Window.alert(e.getMessage());
				}
*/
				MyRequestBuilder builder = new MyRequestBuilder(RequestBuilder.POST, "ServletReturnJson");
				builder.setResponseType(ResponseType.Json);
				try 
				{
					RequestCallback requestCallback = new RequestCallback()
					{
						@Override
						public void onResponseReceived(Request request, Response response) 
						{
							GWT.log("response: " + response); 
							JsObject json = ((MyRequest)request).getMyXMLHttpRequest().getResponseJson();
							JsonReturnObject jro = JsObject.cast(json);
							Window.alert(jro.getX() + "   " + jro.getY());
						}
						
						@Override
						public void onError(Request request, Throwable exception) 
						{
							Window.alert(exception.getMessage());
						}
					};
					builder.sendRequest(null, requestCallback);
				
				}
				catch (RequestException e) 
				{
					Window.alert(e.getMessage());
				}

			
			}
		});
	}
}
