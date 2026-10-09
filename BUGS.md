# Vending Machine Bugs

## Bug 1 - Constructor Array Index Error

### Observed Failure
Creating a new `VendingMachine` caused an `ArrayIndexOutOfBoundsException`.

### Test That Exposed It
`testConstructor_initialState_emptyAndZeroBalance()`

### Source-Code Fault
The constructor loop used `i <= NUM_SLOTS`, causing the loop to attempt to access index 4 in an array of length 4.

### Diagnosis
The JUnit failure reported `Index 4 out of bounds for length 4` at the constructor in `VendingMachine.java`. Since the four valid array indexes are 0 through 3, the loop was executing one iteration too many.

### Correction
Changed the loop condition from:

`i <= NUM_SLOTS`

to:

`i < NUM_SLOTS`

## Bug 2 - insertMoney Rejects Valid Amounts Below One Dollar

### Observed Failure
The parameterized `insertMoney()` test showed that the vending machine
rejected valid amounts of 0.00, 0.01, and 0.99 by throwing a
`VendingMachineException`.

### Test That Exposed It
`testInsertMoney_boundaryValues()`

### Source-Code Fault
The validation condition in `insertMoney()` incorrectly treated
non-negative amounts below 1.00 as invalid.

### Diagnosis
The parameterized boundary test showed that negative values were
correctly rejected and values of 1.00 or greater were accepted, but
0.00, 0.01, and 0.99 were incorrectly rejected. Debugging the method
showed that the validation condition was using the wrong boundary.

### Correction
Changed the validation condition so that only amounts less than 0
cause a `VendingMachineException`.