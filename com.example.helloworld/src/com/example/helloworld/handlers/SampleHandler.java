package com.example.helloworld.handlers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * plugin for load scrip from eclipse 
 * the values of Name scrip and path must be specified on jar plugin conf.properties
 * @auto eurias
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 * 
 */
public class SampleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		LocalException le = executeScript();
		if (le.executed) {
			MessageDialog.openInformation(window.getShell(), "Executed Ok",
					"Script Executed");
		} else {
			MessageDialog.openInformation(window.getShell(), "Executed Error ",
					"Error Executing Script:" + le.e.getMessage());
		}
		return null;
	}

	private LocalException executeScript() {
		Properties prop = new Properties();
		InputStream input = null;
		LocalException result;
		input = getClass().getClassLoader().getResourceAsStream("resources/config.properties");
		try {

			prop.load(input);
		} catch (IOException e1) {
			e1.printStackTrace();

		}

		ProcessBuilder pb = new ProcessBuilder((String) prop.get("name.script"));
		// ProcessBuilder pb = new ProcessBuilder((String) ("adserver_sync"));
		pb.directory(new File((String) prop.get("path.script")));
		// pb.directory(new File((String) ("/home/eurias/bin/")));
		try {
			Process p = pb.start();
			p.waitFor();
			result = new LocalException(true, null);
		} catch (IOException e) {
			result = new LocalException(false, e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			result = new LocalException(false, e);
			e.printStackTrace();
		}
		return result;
	}

	private class LocalException{
		boolean executed;
		Exception e;
		public LocalException(boolean executed, Exception e) {
			super();
			this.executed = executed;
			this.e = e;
		}
		
	}
	
	
	// private MessageConsole findConsole(String name) {
	// ConsolePlugin plugin = ConsolePlugin.getDefault();
	// IConsoleManager conMan = plugin.getConsoleManager();
	// IConsole[] existing = conMan.getConsoles();
	// for (int i = 0; i < existing.length; i++)
	// if (name.equals(existing[i].getName()))
	// return (MessageConsole) existing[i];
	// //no console found, so create a new one
	// MessageConsole myConsole = new MessageConsole(name, null);
	// conMan.addConsoles(new IConsole[]{myConsole});
	// return myConsole;
	// }
}
