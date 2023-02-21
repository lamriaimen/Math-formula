import formula.Constant;
import formula.VariableX;
import formula.Formula;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;


public class VariableXTest {


    @Test
    public void testEval() {

        VariableX Var = new VariableX();
        assertThat(Var.eval(1)).isCloseTo(1, within(.001));
        VariableX Var2 = new VariableX();
        assertThat(Var.eval(4)).isCloseTo(4, within(.001));


    }

    @Test
    public void testToString() {

        VariableX var = new VariableX();
        assertThat(var.toString()).isEqualTo("x");

    }

    @Test
    public void testEquals() {

        VariableX var = new VariableX();
        VariableX var2 = new VariableX();


        assertThat(var.eval(2)).isEqualTo(var2.eval(2));
        assertThat(var.eval(2)).isNotEqualTo((var.eval(1)));

    }


    @Test
    public void testDerivative() {
        VariableX var = new VariableX();
        Formula devVar = var.derivative();

        assertThat(devVar.eval(10)).isEqualTo(1, within(.000));


        Constant constantOne = new Constant(1);

        assertThat(devVar).isEqualTo(constantOne);


    }
}