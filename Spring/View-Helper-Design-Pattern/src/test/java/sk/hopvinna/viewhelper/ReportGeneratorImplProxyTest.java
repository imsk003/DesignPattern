package sk.hopvinna.viewhelper;

import org.junit.Test;

import sk.hopvinna.viewhelper.ReportGenerator;
import sk.hopvinna.viewhelper.ReportGeneratorImplProxy;
import sk.hopvinna.viewhelper.Role;

public class ReportGeneratorImplProxyTest {

    @Test
    public void testGenerateReport() throws Exception {
        Role accessRole=new Role();
        accessRole.setRole("Manager");
        ReportGenerator proxy=new ReportGeneratorImplProxy(accessRole);
        proxy.displayReportTemplate("Pdf",150);
        proxy.generateComplexReport("Pdf",150);
        proxy.generateSensitiveReport();
    }
}