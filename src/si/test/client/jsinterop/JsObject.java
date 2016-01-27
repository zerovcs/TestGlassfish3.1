package si.test.client.jsinterop;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative=true, namespace=JsPackage.GLOBAL, name="Object")
public class JsObject {

	@JsOverlay
	public static <T> T cast(JsObject obj)
	{
		return (T)obj;
	}
}
