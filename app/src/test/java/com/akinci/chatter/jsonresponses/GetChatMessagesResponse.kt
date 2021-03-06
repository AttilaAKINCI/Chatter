package com.akinci.chatter.jsonresponses

class GetChatMessagesResponse {
    companion object {
        val chatMessages = """
            {
                "messages": [
                    {
                        "id": "ASD_123",
                        "text": "Did you receive the e-mail I sent you this morning?",
                        "timestamp": 1602779420,
                        "user": {
                            "id": "2",
                            "avatarURL": "https://randomuser.me/api/portraits/men/78.jpg",
                            "nickname": "John Appleseed"
                        }
                    },
                    {
                        "id": "QWE_456",
                        "text": "Yes!",
                        "timestamp": 1602779540,
                        "user": {
                            "id": "1",
                            "avatarURL": "https://randomuser.me/api/portraits/women/17.jpg",
                            "nickname": "Jane Doe"
                        }
                    },
                    {
                        "id": "ZXC_654",
                        "text": "Definitely 😉",
                        "timestamp": 1602779585,
                        "user": {
                            "id": "2",
                            "avatarURL": "https://randomuser.me/api/portraits/men/78.jpg",
                            "nickname": "John Appleseed"
                        }
                    },
                    {
                        "id": "FGH_899",
                        "text": "Do you really think we need to go with this strategy?",
                        "timestamp": 1602779545,
                        "user": {
                            "id": "1",
                            "avatarURL": "https://randomuser.me/api/portraits/women/17.jpg",
                            "nickname": "Jane Doe"
                        }
                    }
                ]
            }
        """
    }
}