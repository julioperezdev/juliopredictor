package com.juliopredictor.api.Shared.Infrastructure.config;

import com.juliopredictor.api.Announcement.Email.Application.validateEmail.Adapter.MailSenderAdapter;
import com.juliopredictor.api.Announcement.Email.Application.validateEmail.Service.MailSenderServiceImplementation;
import com.juliopredictor.api.Announcement.Email.Infrastructure.Gateway.SpringJavaMailer;
import com.juliopredictor.api.Announcement.Email.Infrastructure.Gateway.ThymeleafMailContentBuilder;
import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.DecideAuthModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.LoginModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.RefreshTokenModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Application.ModelMapper.SignupModelMapper;
import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Adapter.DecideAuthAdapterRepository;
import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Delivery.DecideAuthEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Application.decideAuth.Service.DecideAuthServiceImplementation;
import com.juliopredictor.api.Dashboard.Auth.Application.login.Adapter.LoginAdapterSecurity;
import com.juliopredictor.api.Dashboard.Auth.Application.login.Delivery.LoginEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Application.login.Service.LoginServiceImplementation;
import com.juliopredictor.api.Dashboard.Auth.Application.refreshToken.Adapter.RefreshTokenAdapterRepository;
import com.juliopredictor.api.Dashboard.Auth.Application.refreshToken.Delivery.RefreshTokenEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Application.refreshToken.Service.RefreshTokenServiceImplementation;
import com.juliopredictor.api.Dashboard.Auth.Application.signup.Delivery.SignupEndPoints;
import com.juliopredictor.api.Dashboard.Auth.Application.signup.Repository.SignupAdapterRepository;
import com.juliopredictor.api.Dashboard.Auth.Application.signup.Service.SignupServiceImplementation;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.App.Security.JwtAuthenticationFilter;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.App.Security.JwtProvider;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.App.Security.ManagerAuthenticator;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.RefreshTokenDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.UserDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.UserRolDao;
import com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Dao.VerificationTokenDao;
import com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Adapter.GetCurrenciesOrderedByCmcRankAdapter;
import com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Delivery.GetCurrenciesOrderedByCmcRankEndPoints;
import com.juliopredictor.api.Dashboard.Predictor.Application.getAllOrderedByCmcRank.Service.GetCurrenciesOrderedByCmcRankServiceImplementation;
import com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Adapter.PredicateByCurrencyAdapter;
import com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Delivery.PredicateByCurrencyEndPoints;
import com.juliopredictor.api.Dashboard.Predictor.Application.predicateByCurrency.Service.PredicateByCurrencyServiceImplementation;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.CoinMarketCapClientHistoricalByCurrency;
import com.juliopredictor.api.Dashboard.Predictor.Infrastructure.Gateway.CoinMarketCap.CoinMarketCapClientListTop300;
import com.juliopredictor.api.Shared.Application.ModelMapper.MailModelMapper;
import com.juliopredictor.api.Shared.Application.encodeString.Adapter.StringEncoderAdapter;
import com.juliopredictor.api.Shared.Application.encodeString.Service.StringEncoderService;
import com.juliopredictor.api.Shared.Application.encodeString.Service.StringEncoderServiceImplementation;
import com.juliopredictor.api.Shared.Infrastructure.Gateway.SpringFrameworkStringEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
@EnableJpaRepositories(basePackages = "com.juliopredictor.api.*")
@EntityScan(basePackages = "com.juliopredictor.api.*")
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.juliopredictor.api.*"})
public class SpringDependenciesConfiguration extends WebSecurityConfigurerAdapter{

    @Value("${allowed.origins}")
    private String allowedOriginsUrl;
    //Backoffice.Course
    //Backoffice.Auth
    private final UserDao userDao;
    private final UserRolDao userRolDao;
    private final VerificationTokenDao verificationTokenDao;
    private final RefreshTokenDao refreshTokenDao;
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtProvider jwtProvider;
    ////Backoffice.Predictor
    private final CoinMarketCapClientListTop300 coinMarketCapClientListTop300;
    private final CoinMarketCapClientHistoricalByCurrency coinMarketCapClientHistoricalByCurrency;
    //Announcement.Email
    private final SpringJavaMailer springJavaMailer;
    private final ThymeleafMailContentBuilder thymeleafMailContentBuilder;
    //Shared
    public SpringDependenciesConfiguration(UserDao userDao, UserRolDao userRolDao, VerificationTokenDao verificationTokenDao, RefreshTokenDao refreshTokenDao, UserDetailsService userDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter, JwtProvider jwtProvider, CoinMarketCapClientListTop300 coinMarketCapClientListTop300, CoinMarketCapClientHistoricalByCurrency coinMarketCapClientHistoricalByCurrency, SpringJavaMailer springJavaMailer, ThymeleafMailContentBuilder thymeleafMailContentBuilder) {
        this.userDao = userDao;
        this.userRolDao = userRolDao;
        this.verificationTokenDao = verificationTokenDao;
        this.refreshTokenDao = refreshTokenDao;
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtProvider = jwtProvider;
        this.coinMarketCapClientListTop300 = coinMarketCapClientListTop300;
        this.coinMarketCapClientHistoricalByCurrency = coinMarketCapClientHistoricalByCurrency;
        this.springJavaMailer = springJavaMailer;
        this.thymeleafMailContentBuilder = thymeleafMailContentBuilder;
    }


    /**
     * =======================Backoffice.Course======================
     */
    /**
     * Course/Application/ModelMapper
     */
    /*

    @Bean
    public CourseModelMapper courseModelMapper(){
        return new CourseModelMapper();
    }

    @Bean
    public CourseCreatorRequestResponseModelMapper courseCreatorRequestResponseModelMapper(){
        return new CourseCreatorRequestResponseModelMapper();
    }

    @Bean
    public CourseFinderResponseModelMapper courseFinderResponseModelMapper(){
        return new CourseFinderResponseModelMapper();
    }

     */

    /**
     * Course/Application/Creator
     */
/*
    @Bean
    public CourseCreatorAdapterRepository courseCreatorRepository(){
        return new CourseCreatorAdapterRepository(courseDao, courseModelMapper());
    }

    @Bean
    public CourseCreatorServiceImplementation courseCreatorServiceImplementation(){
        return new CourseCreatorServiceImplementation(courseCreatorRepository());
    }

    @Bean
    public CourseCreatorEndPoints courseCreatorController(){
        return new CourseCreatorEndPoints(courseCreatorServiceImplementation(), courseCreatorRequestResponseModelMapper());
    }

 */

    /**
     *Application/Course/Finder
     */
/*
    @Bean
    public CourseFinderAdapterRepository courseFinderRepository(){
        return new CourseFinderAdapterRepository(courseDao, courseModelMapper());
    }

    @Bean
    CourseFinderServiceImplementation courseFinderServiceImplementation(){
        return new CourseFinderServiceImplementation(courseFinderRepository());
    }

    @Bean
    CourseFinderEndPoints courseFinderController(){
        return new CourseFinderEndPoints(courseFinderServiceImplementation(), courseFinderResponseModelMapper());
    }

 */

    /**
     * =======================Backoffice.Auth======================
     */

    /**
     * Auth/Application/ModelMapper
     */

    @Bean
    public SignupModelMapper signupModelMapper(){
        return new SignupModelMapper();
    }

    @Bean
    public LoginModelMapper loginModelMapper() throws Exception {
        return new LoginModelMapper(loginAdapterSecurity());
    }

    @Bean
    public RefreshTokenModelMapper refreshTokenModelMapper(){
        return new RefreshTokenModelMapper();
    }


    @Bean
    public DecideAuthModelMapper decideAuthModelMapper(){
        return new DecideAuthModelMapper();
    }
    /**
     * Auth/Application/signup
     */

    @Bean
    public SignupAdapterRepository signupAdapterRepository(){
        return new SignupAdapterRepository(
                userDao,
                verificationTokenDao,
                userRolDao,
                signupModelMapper());
    }

    @Bean
    public SignupServiceImplementation signupServiceImplementation(){
        return new SignupServiceImplementation(
                signupAdapterRepository(),
                stringEncoderService(),
                signupModelMapper(),
                mailSenderServiceImplementation(),
                mailModelMapper());
    }

    @Bean
    public SignupEndPoints signupController(){
        return new SignupEndPoints(signupServiceImplementation(), signupModelMapper());
    }

    /**
     * Auth/Application/login
     */

    @Bean
    public LoginEndPoints loginController() throws Exception {
        return new LoginEndPoints(loginServiceImplementation());
    }

    @Bean
    public LoginServiceImplementation loginServiceImplementation() throws Exception {
        return new LoginServiceImplementation(loginAdapterSecurity(), loginModelMapper(), refreshTokenServiceImplementation());
    }

//    @Bean
//    public LoginAdapterSecurity loginAdapterSecurity() throws Exception {
//        return new LoginAdapterSecurity(authenticationManagerBean(),jwtProvider);
//    }

    @Bean
    public LoginAdapterSecurity loginAdapterSecurity() throws Exception {
        return new LoginAdapterSecurity(managerAuthenticator(),jwtProvider);
    }

    /**
     * Auth/Application/refreshToken
     */

    @Bean
    public RefreshTokenEndPoints refreshTokenEndPoints(){
        return new RefreshTokenEndPoints();
    }

    @Bean
    public RefreshTokenServiceImplementation refreshTokenServiceImplementation(){
        return new RefreshTokenServiceImplementation(refreshTokenAdapterRepository());
    }

    @Bean
    public RefreshTokenAdapterRepository refreshTokenAdapterRepository(){
        return new RefreshTokenAdapterRepository(refreshTokenDao, refreshTokenModelMapper());
    }

    /**
     * Auth/Application/decideAuth
     */

    @Bean
    public DecideAuthEndPoints decideAuthEndPoints() throws Exception {
        return new DecideAuthEndPoints(loginController(), signupController(), decideAuthServiceImplementation(), decideAuthModelMapper());
    }
    @Bean
    public DecideAuthServiceImplementation decideAuthServiceImplementation(){
        return new DecideAuthServiceImplementation(decideAuthAdapterRepository());
    }

    @Bean
    public DecideAuthAdapterRepository decideAuthAdapterRepository(){
        return new DecideAuthAdapterRepository(userDao, signupModelMapper());
    }


    /**
     * Auth/Infrastructure
     */

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(allowedOriginsUrl)
                        .allowedMethods("GET", "POST")
                        .maxAge(3600);
            }
        };
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/signup/**")
                .permitAll()
                .antMatchers("/api/login")
                .permitAll()
                .antMatchers("/api/currencies/**")
                .permitAll()
                .antMatchers("/api/predictor")
                .permitAll()
                .antMatchers("/api/decideAuth")
                .permitAll()
                .anyRequest()
                .authenticated();
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Auth/Infrastructure/Security
     */

    @Bean
    public ManagerAuthenticator managerAuthenticator() throws Exception {
        return new ManagerAuthenticator(authenticationManagerBean());
    }

    /**
     * =======================Backoffice.Predictor======================
     */

    /**
     * Predictor/Application/getCurrenciesOrderedByCmcRank
     */
    @Bean
    public GetCurrenciesOrderedByCmcRankEndPoints getCurrenciesOrderedByCmcRankEndPoints(){
        return new GetCurrenciesOrderedByCmcRankEndPoints(getCurrenciesOrderedByCmcRankServiceImplementation());
    }

    @Bean
    public GetCurrenciesOrderedByCmcRankServiceImplementation getCurrenciesOrderedByCmcRankServiceImplementation(){
        return new GetCurrenciesOrderedByCmcRankServiceImplementation(getCurrenciesOrderedByCmcRankAdapter());
    }

    @Bean
    public GetCurrenciesOrderedByCmcRankAdapter getCurrenciesOrderedByCmcRankAdapter(){
        return new GetCurrenciesOrderedByCmcRankAdapter(coinMarketCapClientListTop300);
    }

    /**
     * Predictor/Application/predicateByCurrency
     */

    @Bean
    public PredicateByCurrencyEndPoints predicateByCurrencyEndPoints(){
        return new PredicateByCurrencyEndPoints(predicateByCurrencyServiceImplementation());
    }

    @Bean
    public PredicateByCurrencyServiceImplementation predicateByCurrencyServiceImplementation(){
        return new PredicateByCurrencyServiceImplementation(predicateByCurrencyAdapter());
    }

    @Bean
    public PredicateByCurrencyAdapter predicateByCurrencyAdapter(){
        return new PredicateByCurrencyAdapter(coinMarketCapClientHistoricalByCurrency);
    }

    /**
     * =======================Announcement.Email======================
     */

    /**
     * Email/Application/
     */
    @Bean
    public MailSenderAdapter mailSenderAdapter(){
        return new MailSenderAdapter(springJavaMailer);
    }

    @Bean
    public MailSenderServiceImplementation mailSenderServiceImplementation(){
        return new MailSenderServiceImplementation(mailSenderAdapter());
    }

    /**
     * =======================Shared======================
     */
    @Bean
    public MailModelMapper mailModelMapper(){
        return new MailModelMapper();
    }

    @Bean
    public StringEncoderAdapter stringEncoderAdapter(){
        return new StringEncoderAdapter(springFrameworkStringEncoder());
    }

    @Bean
    public StringEncoderService stringEncoderService(){
        return new StringEncoderServiceImplementation(stringEncoderAdapter());
    }

    @Bean
    public SpringFrameworkStringEncoder springFrameworkStringEncoder(){
        return new SpringFrameworkStringEncoder(passwordEncoder());
    }

    /**
     * =======================OTHERS======================
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
        //return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build();
    }
}
