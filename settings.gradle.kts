if (System.getenv("JITPACK") == null) {
    include(":pos:feature:info:app")
    include(":pos:feature:info:data")
    include(":pos:feature:info:domain")
}

include(":pos:feature:info:presentation")

rootProject.name = "TGG-Mobile-Feature-Info"