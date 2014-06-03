package fr.skytech.application.log4j;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class Log4JInitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		System.out.println("Log4JInitServlet is initializing log4j");
		final String log4jLocation = config
				.getInitParameter("log4j-properties-location");

		final ServletContext sc = config.getServletContext();

		if (log4jLocation == null) {
			System.err
					.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
		} else {
			final String webAppPath = sc.getRealPath("/");
			final String log4jProp = webAppPath + log4jLocation;
			final File yoMamaYesThisSaysYoMama = new File(log4jProp);
			if (yoMamaYesThisSaysYoMama.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				PropertyConfigurator.configure(log4jProp);
			} else {
				System.err
						.println("*** "
								+ log4jProp
								+ " file not found, so initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
		super.init(config);
	}
}