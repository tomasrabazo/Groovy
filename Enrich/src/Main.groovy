import groovy.json.JsonSlurper
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import java.time.*

class Customer {
  Long customerId
  Boolean redemptionEnabled
  String birthDate
}

static void main(String[] args) {

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
   "userIsOwner": true
}'''

String getAccountExtResponseOriginal = '''{
   "soap:Envelope": {
      "xmlns:soap": "http://schemas.xmlsoap.org/soap/envelope/",
      "soap:Body": {
         "ns1:getAccountExtResponse": {
            "xmlns:ns0": "http://dto.services.api.clm.comarch.com/",
            "xmlns:ns1": "http://services.api.ext.clm.comarch.com/CLMServiceInt/",
            "return": {
               "accountId": 8300652,
               "ownerCustomerId": 8013737350,
               "status": "A",
               "type": "NR_BASIC",
               "totalPointBalance": 25640,
               "pointsExpirationBlocked": false,
               "pointBalance": [
                  {
                     "pointType": "EXPAR_CAMP",
                     "points": 60
                  },
                  {
                     "pointType": "EXPAR_JOIN",
                     "points": 567
                  },
                  {
                     "pointType": "AIR_EARN",
                     "points": 0
                  },
                  {
                     "pointType": "EXPAR_EARN",
                     "points": 25013
                  },
                  {
                     "pointType": "COMMIS_CP",
                     "points": 223
                  }
               ],
               "customer": [
                  {
                     "customerId": 8013737350,
                     "accountId": 8300652,
                     "status": "A",
                     "redemptionEnabled": true,
                     "loanEnabled": true,
                     "firstName": "Tomas",
                     "lastName": "Rabazo Marquez",
                     "username": "tomasrabazo",
                     "language": "en",
                     "termsAndConditions": true,
                     "permissions": {
                        "sms": false,
                        "email": false,
                        "post": false,
                        "phone": false,
                        "info": false,
                        "adverts": false,
                        "facebook": false,
                        "removeAvatar": false
                     },
                     "address": {
                        "email": "tomasrabazo123@email.com"
                     },
                     "attribute": [
                        {
                           "code": "BypassRedemCap",
                           "value": 0
                        },
                        {
                           "code": "CNI_1739",
                           "value": 1
                        },
                        {
                           "code": "CP_BALANCE",
                           "value": 25441
                        },
                        {
                           "code": "C_CRD_CARD",
                           "value": ""
                        },
                        {
                           "code": "C_PRFD_ARPRT",
                           "value": ""
                        },
                        {
                           "code": "LANG_REGION",
                           "value": "en-US"
                        },
                        {
                           "code": "MaxTierAtReconExit",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO19",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO20",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO21",
                           "value": 0
                        },
                        {
                           "code": "REG_MARK_PERMISSION",
                           "value": 0
                        },
                        {
                           "code": "REWARDS_FREQUENCY",
                           "value": 1
                        }
                     ],
                     "counter": [
                        {
                           "name": "AirAccRec : COLEGS",
                           "currentValue": 1
                        },
                        {
                           "name": "NameChange : LAST_NAME",
                           "currentValue": 3
                        },
                        {
                           "name": "NameChange : FIRST_NAME",
                           "currentValue": 8
                        },
                        {
                           "name": "NameChange : EMAIL",
                           "currentValue": 12
                        }
                     ],
                     "identifier": {
                        "identifierId": 10209280,
                        "identifierNo": 9931475539,
                        "identifierType": "REWARD_NO",
                        "status": "A"
                     },
                     "householdJoinDate": "2023-10-07",
                     "householdLockDate": "2024-01-07"
                  },
                  {
                     "customerId": 8013737364,
                     "accountId": 8300652,
                     "status": "A",
                     "redemptionEnabled": false,
                     "loanEnabled": true,
                     "login": 9931459361,
                     "firstName": "TesthKBbwrBVWG",
                     "lastName": "TestmnLiOUTOla",
                     "birthDate": "1990-10-10",
                     "gender": "M",
                     "preferedChannel": "P",
                     "username": "test.automation.NWRnezGyvS@norwegian.com",
                     "language": "en",
                     "termsAndConditions": true,
                     "permissions": {
                        "sms": false,
                        "email": false,
                        "post": false,
                        "phone": false,
                        "info": false,
                        "adverts": false,
                        "facebook": false,
                        "removeAvatar": false
                     },
                     "address": {
                        "email": "test.automation.NWRnezGyvS@norwegian.com"
                     },
                     "attribute": [
                        {
                           "code": "BypassRedemCap",
                           "value": 0
                        },
                        {
                           "code": "CNI_1739",
                           "value": 0
                        },
                        {
                           "code": "CP_BALANCE",
                           "value": 199
                        },
                        {
                           "code": "C_CRD_CARD",
                           "value": ""
                        },
                        {
                           "code": "C_PRFD_ARPRT",
                           "value": ""
                        },
                        {
                           "code": "LANG_REGION",
                           "value": "en-GB"
                        },
                        {
                           "code": "MaxTierAtReconExit",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO19",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO20",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO21",
                           "value": 0
                        },
                        {
                           "code": "REG_MARK_PERMISSION",
                           "value": 0
                        },
                        {
                           "code": "REWARDS_FREQUENCY",
                           "value": 0
                        }
                     ],
                     "identifier": {
                        "identifierId": 10207663,
                        "identifierNo": 9931459361,
                        "identifierType": "REWARD_NO",
                        "status": "A"
                     },
                     "householdJoinDate": "2023-10-12",
                     "householdLockDate": "2024-01-12"
                  },
                  {
                     "customerId": 8013737361,
                     "accountId": 8300652,
                     "status": "A",
                     "redemptionEnabled": false,
                     "loanEnabled": true,
                     "login": 9930512144,
                     "firstName": "TestgzGhHmhLAi",
                     "lastName": "TestZRontzGKRx",
                     "birthDate": "1990-10-10",
                     "gender": "M",
                     "preferedChannel": "P",
                     "username": "test.automation.EjsBDTqHjC@norwegian.com",
                     "language": "en",
                     "termsAndConditions": true,
                     "permissions": {
                        "sms": false,
                        "email": false,
                        "post": false,
                        "phone": false,
                        "info": false,
                        "adverts": false,
                        "facebook": false,
                        "removeAvatar": false
                     },
                     "address": {
                        "email": "test.automation.EjsBDTqHjC@norwegian.com"
                     },
                     "attribute": [
                        {
                           "code": "BypassRedemCap",
                           "value": 0
                        },
                        {
                           "code": "CNI_1739",
                           "value": 0
                        },
                        {
                           "code": "CP_BALANCE",
                           "value": 0
                        },
                        {
                           "code": "C_CRD_CARD",
                           "value": ""
                        },
                        {
                           "code": "C_PRFD_ARPRT",
                           "value": ""
                        },
                        {
                           "code": "LANG_REGION",
                           "value": "en-GB"
                        },
                        {
                           "code": "MaxTierAtReconExit",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO19",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO20",
                           "value": 0
                        },
                        {
                           "code": "PARTNERS_NO21",
                           "value": 0
                        },
                        {
                           "code": "REG_MARK_PERMISSION",
                           "value": 0
                        },
                        {
                           "code": "REWARDS_FREQUENCY",
                           "value": 0
                        }
                     ],
                     "identifier": {
                        "identifierId": 10112940,
                        "identifierNo": 9930512144,
                        "identifierType": "REWARD_NO",
                        "status": "A"
                     },
                     "householdJoinDate": "2023-10-07",
                     "householdLockDate": "2024-01-07"
                  }
               ]
            }
         }
      }
   }
}'''

  String getInvitationsResponse = '''{
   "soap:Envelope": {
      "xmlns:soap": "//schemas.xmlsoap.org/soap/envelope/",
      "soap:Body": {
         "ns1:getInvitationsResponse": {
            "xmlns:ns0": "//dto.services.api.clm.comarch.com/",
            "xmlns:ns1": "//services.api.ext.clm.comarch.com/CLMServiceInt/",
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
                     "link": "//rndnew.virtcotr1.katowice.comarch/web/servlet/dispatcher?token=dab5171614eb3225886f2123376e13f8",
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
                     "link": "//rndnew.virtcotr1.katowice.comarch/web/servlet/dispatcher?token=15b5ea8a83a732c1abccf97d42c62f70",
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
                     "link": "//rndnew.virtcotr1.katowice.comarch/web/servlet/dispatcher?token=4493c959cc6235dd862a995b177cd65b",
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
                     "link": "//rndnew.virtcotr1.katowice.comarch/web/servlet/dispatcher?token=f73f229dce19389dba28515450dc0fbe",
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
                     "link": "//rndnew.virtcotr1.katowice.comarch/web/servlet/dispatcher?token=5b8d9292720231ce90321262bc6ae035",
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

  // Build the hashmap(targetCustomerId, invitationId)-----------------------------------
  def invitationMap = [:]
  JsonSlurper slurper = new JsonSlurper()
  Map parsedJson = slurper.parseText(getInvitationsResponse) as Map
  def invitations = parsedJson.get("soap:Envelope").get("soap:Body").get("ns1:getInvitationsResponse").get("return")
  for(def member : invitations) {
    invitationMap.put(member.targetCustomerId, member.id);
  }

  // Build the hashmap(CustomerId, Customer(customerId,redemptionEnabled,birthDate))-----------------------------------
  def customerMap = [:]
  Map parsedgetAccountExtResponseOriginalJson = slurper.parseText(getAccountExtResponseOriginal) as Map
  Long ownercustomerId = parsedgetAccountExtResponseOriginalJson.get("soap:Envelope").get("soap:Body").get("ns1:getAccountExtResponse").get("return").get("ownerCustomerId")

  def customers = parsedgetAccountExtResponseOriginalJson.get("soap:Envelope").get("soap:Body").get("ns1:getAccountExtResponse").get("return").get("customer")
  for (def customer : customers) {
    def object = new Customer(customerId:customer.customerId, redemptionEnabled:customer.redemptionEnabled, birthDate:customer.birthDate)
    customerMap.put(customer.customerId, object);
  }

  // Update invitationID---------------------------------
  def parsedgetAccountExtResponseJson = slurper.parseText(getAccountExtResponse)
  for (member in parsedgetAccountExtResponseJson.get("members")){
    member.inviteCode = invitationMap[member.customerId] ?: ""
  }

  // Update membershipType-------------------------------
  Boolean isOwner, isAdultSpender, isAdult, isChildUpgradable
  for (member in parsedgetAccountExtResponseJson.get("members")){
    isOwner = false
    isAdultSpender = false
    isAdult = false
    isChildUpgradable = false

    // Owner
    if (member.customerId == ownercustomerId) {
      member.membershipType = "owner"
      isOwner = true
    }

    // AdultSpender
    if (!isOwner){
      Customer customer = customerMap[member.customerId]
      if (customer.redemptionEnabled){
        if (customer.birthDate!==null)
        {
          LocalDate birthDate = LocalDate.parse(customer.birthDate);
          LocalDate today = LocalDate.now()
          Period period = Period.between(birthDate,today)
          if (period.getYears()>16) {
            member.membershipType = "adultSpender"
            isAdultSpender = true
          }
        }
      }
    }

    // Adult
    if (!isOwner && !isAdultSpender){
      Customer customer = customerMap[member.customerId]
      if (!customer.redemptionEnabled){
        if (customer.birthDate!==null)
        {
          LocalDate birthDate = LocalDate.parse(customer.birthDate);
          LocalDate today = LocalDate.now()
          Period period = Period.between(birthDate,today)
          if (period.getYears()>16) {
            member.membershipType = "adult"
            isAdult = true
          }
        }
      }
    }

    //ChildUpgradable
    if (!isOwner && !isAdultSpender && !isAdult){
      Customer customer = customerMap[member.customerId]
      LocalDate birthDate = LocalDate.parse(customer.birthDate);
      LocalDate today = LocalDate.now()
      Period period = Period.between(birthDate,today)
      if (period.getYears()==16 && invitationMap[member.customerId]==null) {
        member.membershipType = "childUpgradable"
        isChildUpgradable = true
      }
    }

    // Invited
    if (!isOwner && !isAdultSpender && !isAdult && !isChildUpgradable && invitationMap[member.customerId]!=null){
      member.membershipType = "invited"
    }
  }

  def result = JsonOutput.toJson(parsedgetAccountExtResponseJson)
  println JsonOutput.prettyPrint(result)
}