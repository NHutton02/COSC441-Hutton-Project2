import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    VendingMachine machine;

    @BeforeEach 
        void setUp(){
            machine = new VendingMachine();
        }

    @Test 
    void testConstructor_initialState_emptyAndZeroBalance(){

        

        //assert
        assertEquals(0.0, machine.getBalance(), 0.001);

        assertNull(machine.getItem("A"));
        assertNull(machine.getItem("B"));
        assertNull(machine.getItem("C"));
        assertNull(machine.getItem("D"));

    }

@Test
void testAddItem_validEmptySlot_addsItem() {
    // Arrange
    VendingMachineItem item =
            new VendingMachineItem("Chips", 1.50);

    // Act
    machine.addItem(item, "A");

    // Assert
    assertSame(item, machine.getItem("A"));
}

@Test
void testAddItem_occupiedSlot_throwsException() {
    // Arrange
    VendingMachineItem firstItem =
            new VendingMachineItem("Chips", 1.50);

    VendingMachineItem secondItem =
            new VendingMachineItem("Candy", 1.00);

    machine.addItem(firstItem, "A");

    // Act + Assert
    assertThrows(
        VendingMachineException.class,
        () -> machine.addItem(secondItem, "A")
    );
}

@Test
void testAddItem_invalidCode_throwsException() {
    // Arrange
    VendingMachineItem item =
            new VendingMachineItem("Chips", 1.50);

    // Act + Assert
    assertThrows(
        VendingMachineException.class,
        () -> machine.addItem(item, "E")
    );
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
