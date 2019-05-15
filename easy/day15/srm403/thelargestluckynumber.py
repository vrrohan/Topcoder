def find(n) :
    number = n
    getNumber = False
    if ('0' in str(n) or '1' in str(n) or '2' in str(n) or '3' in str(n) or '5' in str(n) or '6' in str(n) or '8' in str(n) or '9' in str(n)) :
        i = n - 1
        while (i>=4) :
            num = str(n)
            if (('4' not in num) and ('7' not in num)) :
                getNumber = False
                break
            else :
                getNumber = True
            if getNumber==True :
                number = int(num)
                break
            i = i - 1
    return number


print(find(988))
