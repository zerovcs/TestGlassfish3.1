package si.test.client.xhr;

import si.test.client.jsinterop.Blob;
import si.test.client.jsinterop.FormData;
import si.test.client.jsinterop.JsObject;
import si.test.client.jsinterop.XMLHttpRequestUpload;

import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.xhr.client.XMLHttpRequest;

public class MyXMLHttpRequest extends XMLHttpRequest 
{
	public enum ResponseType {
		/**
		 * The default response type -- use
		 * {@link XMLHttpRequest#getResponseText()} for the return value.
		 */
		Default(""),

		/**
		 * The default response type -- use
		 * {@link XMLHttpRequest#getResponseArrayBuffer()} for the return value.
		 * This value may only be used if
		 * {@link com.google.gwt.typedarrays.shared.TypedArrays#isSupported()}
		 * returns true.
		 */
		ArrayBuffer("arraybuffer"),
		Json("json"),
		Blob("blob"),
		Document("document"),
		Text("text");

		private final String responseTypeString;

		private ResponseType(String responseTypeString) {
			this.responseTypeString = responseTypeString;
		}

		public String getResponseTypeString() {
			return responseTypeString;
		}
	}

	protected MyXMLHttpRequest() {
	}
	  public final native void send(Blob blob) /*-{
	    this.send(blob);
	  }-*/;

	  public final native void send(FormData formData) /*-{
	    this.send(formData);
	  }-*/;

	  public final native XMLHttpRequestUpload upload() /*-{
	    return this.upload;
	  }-*/;
	  
	  public final native JsObject getResponseJson() /*-{
	    return this.response;
	  }-*/;

	  public final native Blob getResponseBlob() /*-{
	    return this.response;
	  }-*/;

}
