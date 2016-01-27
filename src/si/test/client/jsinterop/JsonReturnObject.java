package si.test.client.jsinterop;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
@JsType(isNative=true, namespace=JsPackage.GLOBAL)
public interface JsonReturnObject {

	@JsProperty public String getX();
	@JsProperty public int getY();
//	@JsProperty private List<String> list; //tole bi moral z JsArray ali kaj podobnega - liste ni v JS
	
}
