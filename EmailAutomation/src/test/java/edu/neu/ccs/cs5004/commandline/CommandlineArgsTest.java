package edu.neu.ccs.cs5004.commandline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandlineArgsTest {

    @Test
    public void generateTemplateErr() {
        Assert.assertEquals("Error: --email provided but no --email-template was given.\n",
                CommandlineArgs.generateTemplateErr("--email"));
    }
}