package test.iloveyouboss;

import iloveyouboss.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProfileTest {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create(){
        profile = new Profile("Bull Hockey, Inc");
        question = new BooleanQuestion(1,"Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet(){
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer,Weight.MustMatch);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDonCareCriteria(){
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        Answer criteriaAnswer = new Answer(question,Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer,Weight.DontCare);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);

        assertTrue(matches);
    }

    @Test
    public void matches(){
        Profile profile = new Profile("Bull Hockey, Inc");
        Question question = new BooleanQuestion(1,"Got muklk?");

        //answers false when must-match criteria not met
        profile.add(new Answer(question,Bool.FALSE));
        Criteria criteria = new Criteria();
        criteria.add( new Criterion(new Answer(question,Bool.TRUE),Weight.MustMatch));

        assertFalse(profile.matches(criteria));

        //answers true for any don't care criteria
        profile.add(new Answer(question, Bool.FALSE));
        criteria = new Criteria();
        criteria.add(new Criterion(new Answer(question,Bool.TRUE),Weight.DontCare));

        assertTrue(profile.matches(criteria));
    }

    /**
     *  Instead of suggesting what context you are going to test, you can suggest what happens
     *  as a result of invoking some behavior against a certain context
     *
     *  descriptive names follow the form: doingSomeOperationGeneratesSomeResult
     *  or someResultOccursUnderSomeCondition
     *
     *  given-when-then naming pattern, which derives from a process known as
     *  behavior-driven development
     *  givenSomeContextWhenDoingSomeBehaviorThenSomeResultOccurs
     *
     * @Before runs before every test
     * @BeforeClass runs only once before any tests
     *
     * @BeforeClass initializeSomethingReallyExpense
     * @Before createAccount
     * @Test test case 1
     * @After closeConnections
     * @Before createAccount
     * @Test test case 2
     * @After closeConnections@AfterClass
     *
     *
     *
     *
     *
     *
     * */
}
