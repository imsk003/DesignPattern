package sk.hopvinna.proxy;

import org.junit.Test;

import sk.hopvinna.proxy.ReportGenerator;
import sk.hopvinna.proxy.ReportGeneratorImplProxy;
import sk.hopvinna.proxy.Role;

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