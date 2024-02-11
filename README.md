# JavaSiaVirtual
Assignments for my ICSI404 - Computer Assembly class

## Bit Object
- Represents a single bit with values true or false
- Supports comparison operations such as and, or, xor, not, rightshift, leftshift
- Provides methods to set, clear, assign value, and toggle the bit

## Longword Object
- Represents a 32-bit longword
- Supports comparison operations like and, or, xor, not, rightshift, leftshift
- Capable of conversion to unsigned or signed integer
- Provides copy and set methods for convenience

## RippleAdder
- Implements addition and subtraction operations for longwords
- Takes two longwords as input and returns the sum or difference as per user request

### WITH EACH ASSIGNMENT PUSHED, IMPROVEMENTS WERE MADE TO THE OLDER FILES

## Multiplier and ALU
- Multiplier enables multiplication of longwords using ripple adder
- ALU (Arithmetic Logic Unit) controls operations based on Operation code provided

### Main.java was created to keep tests more organized

## Memory and Computer Components
- Memory: Represents the memory component of the virtual machine
- Utilizes longwords for reading and writing to 1024 bytes of memory
- Computer: Constructs the framework of the computer