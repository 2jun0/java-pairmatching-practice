package pairmatching.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeAll
    static void beforeAll() {
        inputValidator = new InputValidator();
    }

    @Test
    void validateFunctionSelectCommandFail() {
        assertThatThrownBy(() -> inputValidator.validateFunctionSelectCommand("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateFunctionSelectCommandSuccess() {
        inputValidator.validateFunctionSelectCommand("1");
    }
}