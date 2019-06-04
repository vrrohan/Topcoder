def makeRope(s) :
    encodedString = ""
    dashRopes = s.split(".")
    totalDotsUsed = 0
    #Add even length dash ropes to list
    dashLength = [x for x in dashRopes if len(x)>0 and len(x)%2==0]
    #reverse sort those even length ropes
    dashLength = list(reversed(sorted(dashLength)))
    for x in range(len(dashLength)) :
        encodedString = encodedString + dashLength[x] + "."
    #Now Add odd length dash ropes to list
    dashLength = [x for x in dashRopes if len(x)>0 and len(x)%2!=0]
    #reverse sort those odd length ropes
    dashLength = list(reversed(sorted(dashLength)))
    for y in range(len(dashLength)) :
        encodedString = encodedString + dashLength[y] + "."
    totalDots = list(s).count(".")
    actualDotsUsed = list(encodedString).count(".")
    for z in range(totalDots - actualDotsUsed) :
        encodedString = encodedString + "."
    return encodedString

print(makeRope("..----.-.-.-.--..-.-----.-..------...-.---.-----.."))
print(makeRope("--..-.---..--..-----.--."))
