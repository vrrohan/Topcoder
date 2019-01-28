def copy(friendsHomework) :
    myHomework = []
    totalSum = sum(friendsHomework)
    for i in range(0, len(friendsHomework)-1) :
        myHomework.append(friendsHomework[i] - 1)
        totalSum = totalSum - myHomework[i]
    myHomework.append(totalSum)
    return myHomework

friendsHomework1 = [10, 20, 30, 40, 50]
friendsHomework2 = [0, 0, 0, 0, 0]
friendsHomework3 = [400, 399, 400, 399, 400]
print([i for i in copy(friendsHomework3)])
