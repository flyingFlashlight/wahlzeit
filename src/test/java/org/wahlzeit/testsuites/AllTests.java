package org.wahlzeit.testsuites;

import org.junit.runner.*;
import org.junit.runners.*;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.wahlzeit.handlers.TellFriendTest.class,
	
	org.wahlzeit.model.AccessRightsTest.class,
	org.wahlzeit.model.CartesianCoordinateTest.class,
	org.wahlzeit.model.SphericCoordinateTest.class,
	org.wahlzeit.model.FlagReasonTest.class,
	org.wahlzeit.model.GenderTest.class,
	org.wahlzeit.model.GuestTest.class,
	org.wahlzeit.model.LocationTest.class,
	org.wahlzeit.model.PhotoFilterTest.class,
	//TODO: Change this to a suite
	org.wahlzeit.model.BiroPhotoTest.class,
	org.wahlzeit.model.BiroPhotoFactoryTest.class,
	org.wahlzeit.model.BiroPhotoManagerTest.class,
	//Ist nicht komplett
	//org.wahlzeit.model.PhotoTest.class,
	org.wahlzeit.model.TagsTest.class,
	org.wahlzeit.model.UserStatusTest.class,
	org.wahlzeit.model.ValueTest.class,
	
	
	//Zeigruenden kommen diese raus
	//org.wahlzeit.model.persistence.AbstractAdapterTest.class,
	org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
	
	org.wahlzeit.services.LogBuilderTest.class,
	
	//Hier reicht uns jetzt die Suite
	org.wahlzeit.services.mailing.EmailServiceTestSuite.class,
	
	//Wurde nicht getestet
	//org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider.class,
	//org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider.class,
	//org.wahlzeit.testEnvironmentProvider.SysConfigProvider.class,
	//org.wahlzeit.testEnvironmentProvider.UserServiceProvider.class,
	//org.wahlzeit.testEnvironmentProvider.UserSessionProvider.class,
	//org.wahlzeit.testEnvironmentProvider.WebFormHandlerProvider.class,
	
	org.wahlzeit.utils.StringUtilTest.class,
	org.wahlzeit.utils.VersionTest.class,
	
	org.wahlzeit.model.BiroTypeTest.class
})

public class AllTests {
	//Do nothing
}
