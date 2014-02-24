import java.util.*;
import org.apache.bsf.*;
import org.apache.bsf.util.*;

// run
// java  -classpath /home/hi25shin/github/groovy_test/src/bsf-2.4.0/lib/bsf.jar:./:/home/hi25shin/github/groovy_test/src/commons-logging-1.1.3/commons-logging-1.1.3.jar BSF

public class BSF {


	public static void main(String[] args) throws Exception {

		String myScript = "println('Hello World')\n return [1, 2, 3]";
		BSFManager manager = new BSFManager();
	
		List answer = (List) manager.eval("groovy", "myScript.groovy", 0, 0, myScript);

	}



}
