package interview;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkListCicleTest {

	
	@Test
	void test2() {
		linkedListT llStr = new linkedListT();
		llStr.add("hola");
		llStr.add("como");
		llStr.add("estas");
		Node cicle=llStr.add("1");
		llStr.add("2");
		llStr.add("3");
		llStr.add("4");
		llStr.add("loop").next = cicle;
		assertTrue(LinkListCicle.hasCicle1(llStr) );
		assertTrue(LinkListCicle.hasCicle2(llStr) );
		assertTrue(LinkListCicle.hasCicle3(llStr) );
	}
	
	@Test
	void test3() {
		linkedListT llStr = new linkedListT();
		llStr.add("hola");
		llStr.add("como");
		llStr.add("estas");
		Node cicle=llStr.add("1");
		llStr.add("2");
		llStr.add("3");
		llStr.add("4");
		//llStr.add("loop").next = cicle;
		assertFalse(LinkListCicle.hasCicle1(llStr) );
		assertFalse(LinkListCicle.hasCicle2(llStr) );
		assertFalse(LinkListCicle.hasCicle3(llStr) );
	}

}
