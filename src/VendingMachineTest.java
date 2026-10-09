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
    void testGetItem_occupiedSlot_returnsItem() {
        //Arrange
        VendingMachineItem item =
            new VendingMachineItem("Chips", 1.50);
    machine.addItem(item, "A");


        //Act
VendingMachineItem result = machine.getItem("A");
        //Assert
assertSame(item, result);

    }

    @Test
void testGetItem_emptySlot_returnsNull() {
    // Act
    VendingMachineItem result = machine.getItem("A");

    // Assert
    assertNull(result);
}

@Test
void testGetItem_invalidCode_throwsException() {
    // Act + Assert
    assertThrows(
        VendingMachineException.class,
        () -> machine.getItem("E")
    );
}




    @Test
    void testInsertMoney() {

    }

    @Test
    void testMakePurchase() {

    }

    @Test
void testRemoveItem_occupiedSlot_removesAndReturnsItem() {
    // Arrange
    VendingMachineItem item =
            new VendingMachineItem("Chips", 1.50);
    machine.addItem(item, "A");

    // Act
    VendingMachineItem removedItem = machine.removeItem("A");

    // Assert
    assertSame(item, removedItem);
    assertNull(machine.getItem("A"));
}

@Test
void testRemoveItem_emptySlot_throwsException() {
    // Act + Assert
    assertThrows(
        VendingMachineException.class,
        () -> machine.removeItem("A")
    );
}

@Test
void testRemoveItem_invalidCode_throwsException() {
    // Act + Assert
    assertThrows(
        VendingMachineException.class,
        () -> machine.removeItem("E")
    );
}

    @Test
    void testReturnChange() {

    }
}
