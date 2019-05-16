def solve(seed, a, b, m) :
    state = seed
    seedSequenceLength = 1
    seedSequence = [seed]
    while 1 :
        state = (state * a + b) % m
        if state in seedSequence :
            seedSequenceLength =  len(seedSequence) - seedSequence.index(state)
            break
        else :
            seedSequence.append(state)
    return seedSequenceLength

print(solve(47, 0, 23, 100))
print(solve(548687, 538918, 376524, 931161))
print(solve(959398, 980978, 36992, 995571))
print(solve(15928, 178567, 573563, 958181))
