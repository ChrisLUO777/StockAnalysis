import urllib2
#coding=utf-8
service=raw_input()
if service.find('stock')!=-1:
    trans=service.split('.')
    code=trans[1]
    start=trans[2]
    end=trans[3]
    url="http://121.41.106.89:8010/api/stock/"+code+"/?start="+start+"&end="+end+"&fields=open+close"
    iheaders = {'X-Auth-Code': 'b675c6229386a50b4d8d464436070570'}
    req=urllib2.Request(url,headers=iheaders)
    page = urllib2.urlopen(req)
    content = page.read()
    print (content.decode('"unicode-escape'))
elif service.find('optional')!=-1:
    trans=service.split('.')
    code=trans[1]
    start=trans[2]
    end=trans[3]
    url="http://121.41.106.89:8010/api/stock/"+code+"/?start="+start+"&end="+end+"&fields=open+close+high+low+volume"
    iheaders = {'X-Auth-Code': 'b675c6229386a50b4d8d464436070570'}
    req=urllib2.Request(url,headers=iheaders)
    page = urllib2.urlopen(req)
    content = page.read()
    print (content.decode('"unicode-escape'))
elif service.find('benchmark')!=-1:
    trans=service.split('.')
    start=trans[1]
    end=trans[2]
    url='http://121.41.106.89:8010/api/benchmark/hs300?start='+start+'&end='+end+'&fields=open+close'
    iheaders = {'X-Auth-Code': 'b675c6229386a50b4d8d464436070570'}
    req=urllib2.Request(url,headers=iheaders)
    page = urllib2.urlopen(req)
    content = page.read()
    print (content.decode('"unicode-escape'))
else:
    print 'error'
