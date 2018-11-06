package org.wahlzeit.services.mailing;

import org.junit.runner.*;
import org.junit.runners.*;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	////TODO Das hier ist eigentlich nur Fleissarbeit	
	org.wahlzeit.services.mailing.EmailServiceTest.class,
	org.wahlzeit.services.EmailAddressTest.class
})

public class EmailServiceTestSuite {
	//Do nothing
}
