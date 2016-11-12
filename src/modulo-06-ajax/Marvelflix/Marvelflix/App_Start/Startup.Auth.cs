namespace Marvelflix
{
    public partial class Startup
    {
        // Enable the application to use OAuthAuthorization. You can then secure your Web APIs
        static Startup()
        {
            PublicClientId = "web";
        }

        public static string PublicClientId { get; private set; }
    }
}
