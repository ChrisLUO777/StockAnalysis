import requests
from json import *
date=raw_input()
trans=date.split('.')
code=trans[0]
start=trans[1]
end=trans[2]
url="http://121.41.106.89:8010/api/stock/"+code+"/?start="+start+"&end="+end+"&fields=open+close+high+low+volume"
headers = {'X-Auth-Code': 'b675c6229386a50b4d8d464436070570'}
r = requests.get(url,headers=headers)
out=JSONDecoder().decode(r.text)
print out["data"]["trading_info"]