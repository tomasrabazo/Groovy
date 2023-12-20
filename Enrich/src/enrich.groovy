package Enrich.src

import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

String getAccountExtResponse = '''{
    "members": [
        {
            "customerId": 8013737350,
            "name": "Tomas",
            "emailAddress": "tomasrabazo123@email.com",
            "membershipType": "",
            "inviteCode": "",
            "householdLockDate": "2024-01-07"
        },
        {
            "customerId": 8013737364,
            "name": "TesthKBbwrBVWG",
            "emailAddress": "test.automation.NWRnezGyvS@norwegian.com",
            "membershipType": "",
            "inviteCode": "",
            "householdLockDate": "2024-01-12"
        },
        {
            "customerId": 8013737361,
            "name": "TestgzGhHmhLAi",
            "emailAddress": "test.automation.EjsBDTqHjC@norwegian.com",
            "membershipType": "",
            "inviteCode": "",
            "householdLockDate": "2024-01-07"
        }
    ],
    "userIsOwner": false
}'''

String getInvitationsResponse = '''{
  "soap:Envelope": {
    "xmlns:soap": "",
    "soap:Body": {
      "ns1:getInvitationsResponse": {
        "xmlns:ns0": "",
        "xmlns:ns1": "",
        "return": [
          {
            "targetCustomerId": 8013737361,
            "targetEmail": "tomas2@g.com",
            "accountId": 8300652,
            "customerId": 8013737350,
            "date": "2023-10-07T16:28:08+02:00",
            "id": 163963,
            "status": "C",
            "type": "H",
            "webLink": {
              "link": "",
              "domain": "H",
              "expirationDate": "2023-11-07T16:28:08+01:00",
              "status": "U"
            }
          },
          {
            "targetCustomerId": 8013737363,
            "targetEmail": "tomas10112@g.com",
            "accountId": 8300652,
            "customerId": 8013737350,
            "date": "2023-10-12T16:49:52+02:00",
            "id": 164221,
            "status": "L",
            "type": "H",
            "webLink": {
              "link": "",
              "domain": "H",
              "expirationDate": "2023-11-12T16:49:52+01:00",
              "status": "A"
            }
          },
          {
            "targetCustomerId": 8013737362,
            "targetEmail": "tomas4@g.com",
            "accountId": 8300652,
            "customerId": 8013737350,
            "date": "2023-10-07T17:28:17+02:00",
            "id": 163964,
            "status": "S",
            "type": "H",
            "webLink": {
              "link": "",
              "domain": "H",
              "expirationDate": "2023-11-07T17:28:17+01:00",
              "status": "A"
            }
          },
          {
            "targetCustomerId": 8013737364,
            "targetEmail": "tomas1123@g.com",
            "accountId": 8300652,
            "customerId": 8013737350,
            "date": "2023-10-12T23:19:48+02:00",
            "id": 164286,
            "status": "C",
            "type": "H",
            "webLink": {
              "link": "",
              "domain": "H",
              "expirationDate": "2023-11-12T23:19:48+01:00",
              "status": "U"
            }
          },
          {
            "targetCustomerId": 8013737359,
            "targetEmail": "tomas@g.com",
            "accountId": 8300652,
            "customerId": 8013737350,
            "date": "2023-10-07T16:26:25+02:00",
            "id": 163991,
            "status": "S",
            "type": "H",
            "webLink": {
              "link": "",
              "domain": "H",
              "expirationDate": "2023-11-07T16:26:25+01:00",
              "status": "A"
            }
          }
        ]
      }
    }
  }
}'''
// Build the hashmap-----------------------------------
def invitationMap = [:]
JsonSlurper slurper = new JsonSlurper()
Map parsedJson = slurper.parseText(getInvitationsResponse)
def invitations = parsedJson.get('soap:Envelope').get('soap:Body').get('ns1:getInvitationsResponse').get('return')
for (def member : invitations) {
    invitationMap.put(member.targetCustomerId, member.id)
}
// Modify invitationID---------------------------------
Map parsedgetAccountExtResponseJson = slurper.parseText(getAccountExtResponse)
JsonBuilder builder = new JsonBuilder(parsedgetAccountExtResponseJson)
def members = parsedgetAccountExtResponseJson.get('members')
for (int member in 0..members.size() - 1) {
    if (invitationMap.get(members[member].customerId) != null) {
        builder.content.members[member].inviteCode = invitationMap.get(members[member].customerId)
    }
}
println builder.toString()
