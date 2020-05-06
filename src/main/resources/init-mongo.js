db.createUser(
    {
        user: "itms_user",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "itms"
            }
        ]
    },
    {
        w: "majority",
        wtimeout: 5000
    }
)