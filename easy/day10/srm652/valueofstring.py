def findValue(s) :
    stringValue = 0
    for i in range(len(s)) :
        codePoint = ord(s[i]) % 96
        minSmallChars = 0
        for j in range(len(s)) :
            if s[i]>=s[j] :
                minSmallChars += 1
        stringValue += (codePoint * minSmallChars)
    return stringValue

print(findValue('babca'))
print(findValue('zz'))
print(findValue('thequickbrownfoxjumpsoverthelazydog'))
print(findValue('y'))
print(findValue('zyxwvutsrqponmlkjihgfedcba'))
