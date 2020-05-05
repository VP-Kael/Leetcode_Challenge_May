"""
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:
    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

"""


def findComplement(self, num: int) -> int:
    return num ^ (2 ** (len(bin(num)[2:])) - 1)


def main():
    input = 5
    print(findComplement(main, input))


if __name__ == '__main__':
    main()