package si.test.client.jsinterop;

import java.util.logging.Level;
import java.util.logging.Logger;

import jsinterop.annotations.JsMethod;

public class JsonUtil 
{
	private static  Logger logger = Logger.getLogger("JsonUtil");
	
	/* Lahko takole, vendar ni najbolj optimalno 
	@JsType(isNative=true, namespace=JsPackage.GLOBAL)
	public interface JSON
	{
		JsObject parse(String json);
	}
	
	@JsProperty(namespace=JsPackage.GLOBAL, name="JSON")
	public static native JSON getJSON();
	*/
	
	//Enostavneje kot zgoraj
	//Namenoma ta metoda in ne native kot public, da lahko še kar vkomponiramo npr. exception handling
	public static JsObject parseJson(String json)
	{
		try
		{
			logger.log(Level.INFO, "Parsing JSON");
			return parse(json);
		}
		catch(Exception e)
		{
			logger.log(Level.SEVERE, "JsonUtil: Exception while parsin JSON: ", e);
		}
		return null;
	}
	
	@JsMethod(namespace="JSON")
	static native JsObject parse(String json);
	
	private JsonUtil() {
	}
}
