package ua.twotwo.utils;

import static junit.framework.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml" })
public class AlphabetBeanTest {
    public static final String ERROR_MESS = "Alphabet char pairs not found";
    @Autowired
    private AlphabetBean alphabetBean;

    @Test
    public void testGetAlphabetCharPairs() throws Exception {
        assertFalse(ERROR_MESS, alphabetBean.getCyrillicAlphabet().isEmpty());
    }
}