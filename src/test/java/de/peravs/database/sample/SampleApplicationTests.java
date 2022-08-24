package de.peravs.database.sample;

import de.peravs.database.sample.service.MyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(SampleApplicationTests.class);

	@Autowired
	private MyService myService;

	@Test
	void databaseDeleteTestFails() {

		LOG.debug("---- create entities");
		myService.createAndSaveEntity1();

		LOG.debug("---- delete entity2");
		myService.deleteEntity2UsingRepo2();

		int countOfEntity2AfterSave = myService.countEntity2();

		Assertions.assertThat(countOfEntity2AfterSave).isEqualTo(1);
	}

	@Test
	void databaseDeleteTestSuccess() {

		LOG.debug("---- create entities");
		myService.createAndSaveEntity1();

		LOG.debug("---- delete entity2");
		myService.deleteEntity2UsingRepo1();

		int countOfEntity2AfterSave = myService.countEntity2();

		Assertions.assertThat(countOfEntity2AfterSave).isEqualTo(1);
	}

}
