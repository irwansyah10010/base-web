package io.irwansyahdev96.backoffice.base.constant;


public interface SecurityUrl {
    /*
     * url denied to access on everywhere
     */
    String[] DENY_URL = {
        "/webjars/**/package.json",
        "/webjars/**/bower.json",
        "/webjars/**/package-lock.json",
        "/webjars/**/.travis.yml",
        "/webjars/**/composer.json",
        "/webjars/**/*.map"
    };

    /*
     * url denied to access via web browser / protocol http
     */
    String[] ONCE_REQUEST_URL = {
        "/assets/**",
        "/vendor/**",
        "/webjars/**"
    };
    
    /*
     * url to render web (check via once req)
     */
    // String[] PERMIT_URL = Stream.concat(
    //     Arrays.stream(ONCE_REQUEST_URL),
    //     Arrays.stream(new String[] {
    //         "/generalapi/**",
    //         "/error-400",
    //         "/error-403",
    //         "/error-404",
    //         "/error-500",
    //         "/error-503"
    //     })
    // ).toArray(String[]::new);

    /*
     * url to render web (check without once req)
     */
    String[] PERMIT_URL = {
        "/generalapi/**",
        "/error-400",
        "/error-403",
        "/error-404",
        "/error-500",
        "/error-503"
    };


}
