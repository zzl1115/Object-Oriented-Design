package edu.neu.ccs.cs5004.model;


import org.junit.Assert;

public class TemplateTest {
    private Template emailTemplateTest;
    private Template sameRefEmailTemplateTest;
    private Template sameStateEmailTemplateTest;
    private Template diffEmailTemplate;

    @org.junit.Before
    public void setUp() throws Exception {
        emailTemplateTest = new Template(new FileName("Email-template.txt"));
        sameRefEmailTemplateTest = emailTemplateTest;
        sameStateEmailTemplateTest = new Template(new FileName("Email-template.txt"));
        diffEmailTemplate = new Template(new FileName("d.txt"));
    }

    @org.junit.Test
    public void getTemplateName() {
        Assert.assertEquals(new FileName("Email-template.txt"), emailTemplateTest.getTemplateName());
    }

    @org.junit.Test
    public void equals() {
        Template nullEmailTemplateTest = null;
        Template anotherEmailTemplateTest = new Template
                (new FileName("Email-template.txt"));
        Assert.assertTrue(emailTemplateTest.equals(sameRefEmailTemplateTest));
        Assert.assertTrue(emailTemplateTest.equals(sameStateEmailTemplateTest));
        Assert.assertEquals(emailTemplateTest.equals(sameStateEmailTemplateTest),
                sameStateEmailTemplateTest.equals(emailTemplateTest));
        Assert.assertEquals(emailTemplateTest.equals(sameStateEmailTemplateTest)
                        && sameStateEmailTemplateTest.equals(anotherEmailTemplateTest),
                emailTemplateTest.equals(anotherEmailTemplateTest));
        Assert.assertFalse(emailTemplateTest.equals(nullEmailTemplateTest));
        Assert.assertFalse(emailTemplateTest.equals(new Integer(9)));
        Assert.assertFalse(emailTemplateTest.equals(new Template
                (new FileName("letter-template.txt"))));
        Assert.assertFalse(emailTemplateTest.equals(diffEmailTemplate));
    }

    @org.junit.Test
    public void testHashCode() {
        Assert.assertEquals(emailTemplateTest.equals(sameStateEmailTemplateTest),
                emailTemplateTest.hashCode() == sameStateEmailTemplateTest.hashCode());
        Assert.assertEquals(emailTemplateTest.equals(sameRefEmailTemplateTest),
                emailTemplateTest.hashCode() == sameRefEmailTemplateTest.hashCode());
        Assert.assertEquals(!emailTemplateTest.equals(new Template
                        (new FileName("letter-template.txt"))),
                emailTemplateTest.hashCode() != new Template
                        (new FileName("letter-template.txt")).hashCode());
        Assert.assertEquals(!emailTemplateTest.equals(diffEmailTemplate),
                emailTemplateTest.hashCode() != diffEmailTemplate.hashCode());
    }
}