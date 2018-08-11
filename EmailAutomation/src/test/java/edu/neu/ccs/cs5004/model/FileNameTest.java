package edu.neu.ccs.cs5004.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.FileName;

public class FileNameTest {
  private FileName fileNameTest;
  private FileName sameRefFileNameTest;
  private FileName sameStateFileNameTest;
  private FileName diffFileName;

  @Before
  public void setUp() throws Exception {
    fileNameTest = new FileName("a.txt");
    sameRefFileNameTest = fileNameTest;
    sameStateFileNameTest = new FileName("a.txt");
    diffFileName = new FileName("b.txt");
  }

  @Test
  public void equals() {
    FileName nullFileNameTest = null;
    FileName anotherFileNameTest = new FileName("a.txt");

    Assert.assertTrue(fileNameTest.equals(sameRefFileNameTest));
    Assert.assertTrue(fileNameTest.equals(sameStateFileNameTest));
    Assert.assertEquals(fileNameTest.equals(sameStateFileNameTest),
            sameStateFileNameTest.equals(fileNameTest));
    Assert.assertEquals(fileNameTest.equals(sameStateFileNameTest)
                    && sameStateFileNameTest.equals(anotherFileNameTest),
            fileNameTest.equals(anotherFileNameTest));
    Assert.assertFalse(fileNameTest.equals(nullFileNameTest));
    Assert.assertFalse(fileNameTest.equals(new Integer(9)));
    Assert.assertFalse(fileNameTest.equals(diffFileName));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(fileNameTest.equals(sameStateFileNameTest),
            fileNameTest.hashCode() == sameStateFileNameTest.hashCode());
    Assert.assertEquals(fileNameTest.equals(sameRefFileNameTest),
            fileNameTest.hashCode() == sameRefFileNameTest.hashCode());
    Assert.assertEquals(!fileNameTest.equals(diffFileName),
            fileNameTest.hashCode() != diffFileName.hashCode());
  }
}