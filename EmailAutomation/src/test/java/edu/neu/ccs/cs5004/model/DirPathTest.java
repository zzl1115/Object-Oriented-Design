package edu.neu.ccs.cs5004.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.DirPath;

public class DirPathTest {
  private DirPath dirPathTest;
  private DirPath sameRefDirPathTest;
  private DirPath sameStatedDrPathTest;
  private DirPath diffDirPath;

  @Before
  public void setUp() throws Exception {
    dirPathTest = new DirPath("email");
    sameRefDirPathTest = dirPathTest;
    sameStatedDrPathTest = new DirPath("email");
    diffDirPath = new DirPath("b.txt");
  }

  @Test
  public void equals() {
    DirPath nulldirPathTest = null;
    DirPath anotherdirPathTest = new DirPath("email");

    Assert.assertTrue(dirPathTest.equals(sameRefDirPathTest));
    Assert.assertTrue(dirPathTest.equals(sameStatedDrPathTest));
    Assert.assertEquals(dirPathTest.equals(sameStatedDrPathTest),
            sameStatedDrPathTest.equals(dirPathTest));
    Assert.assertEquals(dirPathTest.equals(sameStatedDrPathTest)
                    && sameStatedDrPathTest.equals(anotherdirPathTest),
            dirPathTest.equals(anotherdirPathTest));
    Assert.assertFalse(dirPathTest.equals(nulldirPathTest));
    Assert.assertFalse(dirPathTest.equals(new Integer(9)));
    Assert.assertFalse(dirPathTest.equals(diffDirPath));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(dirPathTest.equals(sameStatedDrPathTest),
            dirPathTest.hashCode() == sameStatedDrPathTest.hashCode());
    Assert.assertEquals(dirPathTest.equals(sameRefDirPathTest),
            dirPathTest.hashCode() == sameRefDirPathTest.hashCode());
    Assert.assertEquals(!dirPathTest.equals(diffDirPath),
            dirPathTest.hashCode() != diffDirPath.hashCode());
  }

  @Test
  public void getDirPath() {
    Assert.assertEquals("email", dirPathTest.getDirPath());
  }
}