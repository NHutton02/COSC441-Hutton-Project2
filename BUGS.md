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