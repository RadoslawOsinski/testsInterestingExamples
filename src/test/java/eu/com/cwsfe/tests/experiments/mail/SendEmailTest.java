package eu.com.cwsfe.tests.experiments.mail;

import com.icegreen.greenmail.junit.GreenMailRule;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.Rule;
import org.junit.Test;

import javax.mail.MessagingException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Radoslaw Osinski.
 */
public class SendEmailTest {

    @Rule
    public final GreenMailRule greenMail = new GreenMailRule(ServerSetupTest.SMTP);

    @Test
    public void testSend() throws MessagingException {
        GreenMailUtil.sendTextEmailTest("to@localhost.com", "from@localhost.com",
                "some subject", "some body"); // --- Place your sending code here instead
        assertEquals("some body", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));
        assertEquals("some subject", greenMail.getReceivedMessages()[0].getSubject());
    }

}
