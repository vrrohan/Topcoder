def construct(head, rest) :
    wildSequence = [head]
    rest = list(rest)
    if len(rest) > 0 :
        minListElement = min(rest)
        if minListElement > head :
            index = 0
            while(len(rest)!=0) :
                if index%2==0 :
                    wildSequence.append(max(rest))
                    rest.remove(max(rest))
                    index = index + 1
                else :
                    wildSequence.append(min(rest))
                    rest.remove(min(rest))
                    index = index + 1
        else :
            index = 0
            while(len(rest)!=0) :
                if index%2==0 :
                    wildSequence.append(min(rest))
                    rest.remove(min(rest))
                    index = index + 1
                else :
                    wildSequence.append(max(rest))
                    rest.remove(max(rest))
                    index = index + 1
    return wildSequence

print(construct(10, [1, 2, 3]))
