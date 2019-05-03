"""
Problem Statement for StringTransform
Problem Statement

	You are given the Strings s and t. Both strings have the same length. You are allowed to modify s. In each step you may choose two valid indices i and j such that i > j, and change s[i] to s[j].
	For example, if s = "abc", you may choose i=2 and j=0, which will change s to "aba".
	Return "Possible" (quotes for clarity) if you can change s into t by a sequence of zero or more steps. Otherwise, return "Impossible".
	Note that the return values are case-sensitive.

Definition
Class:	StringTransform
Method:	isPossible
Parameters:	String, String
Returns:	String
Method signature:	String isPossible(String s, String t)
(be sure your method is public)

Constraints
-	s will contain between 1 and 1,000 characters, inclusive.
-	s and t will be of equal length.
-	s will contain only lowercase English letters.
-	t will contain only lowercase English letters.

Examples
0)	"abc"
"aba"
Returns: "Possible"
This is the example from the problem statement. We can change s into t by changing s[2] to s[0].

1)	"abc"
"bbc"
Returns: "Impossible"
Note that in each step i must be greater than j. You are not allowed to choose i=0 and j=1.

2)	"topcoder"
"topcoder"
Returns: "Possible"
The two strings are equal, so we don't have to make any changes.

3)	"rdmcxnnbbe"
"rdrrxrnxbe"
Returns: "Possible"

4)	"rdmcxnnbbe"
"rdqrxrnxbe"
Returns: "Impossible"
"""
def isPossible(s, t) :
    isTransformationPossible = "Possible"
    if s[0]!=t[0] :
        isTransformationPossible = "Impossible"
    else :
        for i in range(1, len(s)) :
            if (s[i]!=t[i]) :
                subStringOfS = s[0:i]
                if t[i] not in subStringOfS :
                    isTransformationPossible = "Impossible"
                    break
    return isTransformationPossible

print(isPossible("rdmcxnnbbe", "rdrrxrnxbe"))
print(isPossible(
				"hhjxrjjqalhcsdleqvrfcilnsxvhfdyojqyiwpqhtjbqrrnwcmtrvpmivsbwriccqtrzrdbhdepdmfkmvtrlbbczsagheprwpqebiyfnaqweruacxxrtboometosdlnhaffiungnlnnnhgxhzihdulqkvpjgadqjhgxkalxhafygsyyrygilzykqbatkokfcsjekffrbzfalsodcdtlzsweguiocmtmrhinvbynmyhozenixazegftaeectqyjletznprvoxzkltvvljmsmcfejakimvihztemxwwkegpwwsqwscycgefgfzmtcgenaxnpunuzyhlbjlptsikkvzusegtjyuaobxwgyrstsfjcfuicdlkpuvdbifvtdxsqwzhlyohnmmhxbhxbtmuhwuyyfqwlyxkirbzjdtgabutlgknjosyvjffcwyvypvaymeaelnzivlbztuelstxmodhmrmylnkojosqdzieklvwpvgtysxqumuhjfkzeliylnwdatwqxycpgkxulevnuexeelkqjtzmjewkcooiineabvxgyqwkgrjrqickegnsbjyxbexvfnytcdamuqkvuvcoklblxiogcmvecbqcpoxchwrkfwvacxgufsixkgqfjioqudjxozsvvwdfqxlgcumqnevhdgyynjxtldsbdmybforqehjdydvmjngfgwnjpvohbdyfnxuwxilulykakdznzrmdnntreminoerpekywxnhnkuirmclculohldyqtupxgjwiesombqmmrfnayvwlmmqothsbfnhzehoxmzvygeheezwleqsneyehzhrdnrdafclgayqywbgfimniyxdtvectgwdjdjiidxkqiwlxcgduyxegukwpomnmqfrpwdgvmxmovyexkxlohuqoyvyogvgcokwmkbrroblghjwevgzhwpcgvjvraplbokgxutafiobldrxjlnsesjymlicirxucfqxcqjjlmdzsddf",
				"hhhhxhhjhhjhhhxxjxhhxhxjhhhnnjqxhhaijhhjjhhxhghhxxqlhhhhjjjjxircrhmhjhqhjrhxhjynqlhhhhoxxfxxnhxhxhicxrhihxooxhhxjhxijxnxrhrhnxinijxnmijjjsxihqjslhhijjqiqyjrxhhilqjsrxfwajxijhqcjhjhihjqbhhhhhikcjijqjdbhxwrhojhmxbjxzexcqlhvlihhihvbnrhrihfxhniyxfixcaxhijqmxhejxhihzrxykjllhxhmhmrlvqamqfqhhhhriqlhqxqxquemwrklcxshcqvvhqmehhhgnhnhiizllhhixomhhvyjihkhiuutjililiymxjlxejvhhnkkcxmblljltooiuwxllhhhnmxjrqxkxhhhhhmhcqvhihijxlruyhjxfjfijghnhxhhvhixtjhmzhxqdidhzxqvjlqhkjqvxqhqhxhxhrbxfrjhwinxdphhhihfhxyjkhclihzmxjthnxfvxswahjrxcjgherfpkxhjxuhiqirwesvvrhsccdvpbiarxskviixxekoeqhakqqrivvqbhrjvtkxjhvwzhqjfqmfzdzzgzkkinpvxwfbhjonzhhjinzwroqqhizubrqxehihhkvjqqqlmwvjrhmiwlmmhhhxhijiinrinvgjhhjlqwjuhhrnhrmswgjghvhxxhcjdvxelvtcikxlukbhckhjjrzqfdhaqxhilixwhvkdoxqhnrvijuqxbwqwcqbqbqhhkxnopmihvehxhrvrnnunhxwjxxxwqiobdmvtuxxxzvryezrdpmpijjyhhzlgvnjhvhnldutyyqbrfjfqnkvfjjquhofhfniadhxllthujhuwtrdlmyqwxyitltbkuwiwherzyhlgvtulzehdxhxlhqmiowxmmkhjhxinbwfujqrohcxzuberzhocvlhtqvjqiuhmgivbvxwphhvxnrbhejndxqhhgeifjgkhzqch"))
print(isPossible(
				"gwwencxqsmcshqvhtjvaubqviamywiktffhsbpgoolbzxrtazffucfmdgntiivphkdzlmwlotraigovpfdksatejvgrpowwtebtpqudbxolukaaqynbpwufvmaxtkyrnoesidjsytnvjflaqfbxnetwrqhrifkchbbgcgezrenfttvkqvzgnmvkiwwdbxecgdirywkvoliwifbghbasnckztlxqrxrigkyygzqkafsnxncrnnoyxebrnjqxtrqyjnptogtgyplprkakpajxwrtbplafamshkrzcxgfohcrgjrozygvhubrhpjdbrncqevhmhlfzgrxixsdjqkziphoqjqcihomfmursicmtlpfpvnkiemlqleovssoyymjcjkswzfcrrhfrrosurdaotuuggiuuqytalxpiomdszanemeotgobdzaxqbnnwuqsodygxjccqtzfooiodbandxdsbruvkucaefwdnhzrhtvkmdnbwqcdckdocxuzopgdkuypuayzgumemussttnbfgsnrwcbfbggvfqotglzmcnlcrdozfggbpsmxnxpgopjochyljiwhbabtyuwkosqqudyniibnfglibfvofnwufgudwjmaoetyztsnsybjihfvchjyjmakcvjktttdyvqraenmqawuxjddfvcyarphukgzrfobdkfcuuraulkyypmhxuffipchtgtvzpyggmjkrtndvvlujhaozzqxtqsbvcyvfaytbkxhnyjguhjibquzcvjwldjyuhfgvkxlzotrugzoxhohfoiykfaursygzkygfzbkxjnnrxfwpchnlnqbecjippxopwkzmhzqxbyfcmtwpkiodjtqzzrrxzgeoahjqeiecrczhjswmmbnlwxkbbipocvbhnjcnfihltvqjfiuskupvcihlnkoqrieqaihuqlcbupjyausspnamxthmbfsrzojuwempwgpifcwehnybfbacvdodktkjalsi",
				"ggwwwwxgwwwwwgnsgggwcwwswwinswcnignnxpbwwlnncwnninnaknmdagnggdwswbgcwkwotgwwsoinssciataaopdvexegepwiauggxswbswucbabpxxkgevbwonpvnesewjibtswnrwasfvcnepcwaaragrctwbictgdrbwdxcsvnengnwbfgcznwfwnasninerwsganewgbqbasnekifvxigowngwfnazwbyfgnmiubdtpyxxnewignninwieetpwwrintannpevisscwubpitgncsnwvmgxwbwdwpsncextsetwediwjibzncqebeiglnwtbgncjnjqpzitvzqjomwhodjyxwwoctnlxccxrkpqnwxtytjtstzgajcaaoiwwuqiyjonwwpfgnonupndnkmalsaqesiagxefwieeafgvaeizazwbmnwiqechplaenewcniobbkwbaedixslzdvwdktwwgscnceasvetfctwguactgudxsvladhlxgdixkcklanzkniwqptgleqgdggdbvwnuwwcxnfnaejswvgwfsxiuwcbczwzpegabfanbwvxbfadwdcknguqffbplikxkgzytfxxgwnukbwdsjmvowhfztrxssdlqtvtchjntfcgcikktipaylurjttabkowxifnfqtdidvpnkntswkbcbrluvcnpwqerqcbcsfbipwyrkungdgbsuvadjvfpvdpponodrqnamuizebzvxwcerdutekbehwdbdmpxbkwalsguegrgtttzwqdetcatgovibcwsdtvornggqigvktuiuuirksaalzfwbfnmlanzaxkamrcwteqxxtrkahfnutpnwrqexnerbgwrhkcneiccxfnjxfswwgqyindkbifbbdbtrsfdchidteqzjuuioetxpwagtdkxagwwraqfibckoxgrcssscacixkbtlwiwlgtudztzwtjdwfrktmxnftrqsiahnwijddnd"))
