import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    @Test 
    void testConstructor_initialState_emptyAndZeroBalance(){

        VendingMachine machine = new VendingMachine();

        //assert
        assertEquals(0.0, machine.getBalance(), 0.001);

        assertNull(machine.getItem("A"));
        assertNull(machine.getItem("B"));
        assertNull(machine.getItem("C"));
        assertNull(machine.getItem("D"));

    }





    @Test
    void testAddItem() {

    }

    @Test
    void testGetBalance() {

    }

    @Test
    void testGetItem() {

    }

    @Test
    void testInsertMoney() {

    }

    @Test
    void testMakePurchase() {

    }

    @Test
    void testRemoveItem() {

    }

    @Test
    void testReturnChange() {

    }
}
