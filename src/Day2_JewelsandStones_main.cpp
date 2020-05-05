/*
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *  Input: J = "aA", S = "aAAbbbb"
 *  Output: 3
 *
 * Example 2:
 *  Input: J = "z", S = "ZZ"
 *  Output: 0
 */

#include <iostream>
#include <unordered_set>

static int numJewelsInStones(std::string J, std::string S) {
    std::unordered_set<char> charSet;

    int ans = 0;

    for (char& ch : J)
        charSet.insert(ch);

    for (char& key : S)
        if (charSet.find(key) != charSet.end())
            ans++;
    return ans;
}

int main() {
    char J[] = "aA";
    char S[] = "aAAbbbb";
    std::cout << numJewelsInStones(J, S) << std::endl;
    return 0;
}


