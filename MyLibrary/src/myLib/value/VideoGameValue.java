package myLib.value;

import myLib.Util;

/**
 * A value object representing a video game
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code system}: a {@link VideoGameSeriesValue} value object representing the system on which the video game was released</li>
 * <li>{@code series}: a {@link VideoGameSeriesValue} value object representing the series of the video game (optional)</li>
 * <li>{@code players}: an <b>{@code int}</b> representing the number of players that can play the video game (defaults to <b>{@code 1}</b>)</li>
 * <li>{@code hasCoop}: a {@link Boolean} indicating if the video game has cooperative mode (optional)</li>
 * <li>{@code originalSystem}: a {@link VideoGameSeriesValue} value object representing the <b><i>original</i></b> system on which the video game was released
 * (optional)</li>
 * <li>{@code compilation}: a {@link VideoGameValue} value object representing the compilation video game on which the video game is found (optional)</li>
 * <li>{@code strategyGuide}: a {@link BookValue} value object representing the strategy guide (optional)</li>
 * <li>{@code copies}: an <b>{@code int}</b> representing the number of copies of the video game that are held (defaults to <b>{@code 1}</b>)</li>
 * <li>{@code cartridge}: a boolean indicating if the video game has a disc or cartridge (as opposed to being a digital copy)</li>
 * <li>{@code downloadLocation}: a String representing the location where the video game is downloaded (optional)</li>
 * <li>{@code numberDiscs}: an {@link Integer} representing the number of discs the video game comprises (optional)</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBVG}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class VideoGameValue extends ItemValue
{
    /**
     * An enum representing the format of the video game
     * <ul>
     * <li>Value(s):</li>
     * <ul>
     * <li>{@link Format#CART}: {@code "Cartridge/Disc"}</li>
     * <li>{@link Format#DNLD}: {@code "Download"}</li>
     * </ul>
     * <li>Field(s):</li>
     * <ul>
     * <li>{@code text}: a String representing the text of the format</li>
     * </ul>
     * </ul>
     * 
     * @author knerd.knitter
     */
    public enum Format
    {
     CART( "Cartridge/Disc" ),
     DNLD( "Download" );

        private String text;

        Format( String text )
        {
            this.text = text;
        }

        public String text()
        {
            return text;
        }
    }

    private VideoGameSystemValue system;
    private VideoGameSeriesValue series;
    private int                  players = 1;
    private Boolean              hasCoop;
    private VideoGameSystemValue originalSystem;
    private VideoGameValue       compilation;
    private BookValue            strategyGuide;
    private int                  copies  = 1;
    private boolean              cartridge;
    private String               downloadLocation;
    private Integer              numberDiscs;

    public VideoGameValue( String uniqueKey,
                           String name,
                           VideoGameSystemValue system,
                           VideoGameSeriesValue series,
                           int players,
                           Boolean hasCoop,
                           VideoGameSystemValue originalSystem,
                           BookValue strategyGuide,
                           int copies,
                           boolean cartridge,
                           String downloadLocation,
                           Integer numberDiscs )
    {
        super( uniqueKey, name, ItemType.VG );
        this.system = system;
        this.series = series;
        this.players = players;
        this.hasCoop = hasCoop;
        this.originalSystem = originalSystem;
        this.strategyGuide = strategyGuide;
        this.copies = copies;
        this.cartridge = cartridge;
        this.downloadLocation = downloadLocation;
        this.numberDiscs = numberDiscs;
    }

    public VideoGameValue getCompilation()
    {
        return compilation;
    }

    public int getCopies()
    {
        return copies;
    }

    public String getDownloadLocation()
    {
        return downloadLocation;
    }

    public Boolean getHasCoop()
    {
        return hasCoop;
    }

    public Integer getNumberDiscs()
    {
        return numberDiscs;
    }

    public VideoGameSystemValue getOriginalSystem()
    {
        return originalSystem;
    }

    public int getPlayers()
    {
        return players;
    }

    public VideoGameSeriesValue getSeries()
    {
        return series;
    }

    public BookValue getStrategyGuide()
    {
        return strategyGuide;
    }

    public VideoGameSystemValue getSystem()
    {
        return system;
    }

    public boolean isCartridge()
    {
        return cartridge;
    }

    public void setCartridge( boolean cartridge )
    {
        this.cartridge = cartridge;
    }

    public void setCompilation( VideoGameValue compilation )
    {
        this.compilation = compilation;
    }

    public void setCopies( int copies )
    {
        this.copies = copies;
    }

    public void setDownloadLocation( String downloadLocation )
    {
        this.downloadLocation = downloadLocation;
    }

    public void setHasCoop( Boolean hasCoop )
    {
        this.hasCoop = hasCoop;
    }

    public void setNumberDiscs( Integer numberDiscs )
    {
        this.numberDiscs = numberDiscs;
    }

    public void setOriginalSystem( VideoGameSystemValue originalSystem )
    {
        this.originalSystem = originalSystem;
    }

    public void setPlayers( int players )
    {
        this.players = players;
    }

    public void setSeries( VideoGameSeriesValue series )
    {
        this.series = series;
    }

    public void setStrategyGuide( BookValue strategyGuide )
    {
        this.strategyGuide = strategyGuide;
    }

    public void setSystem( VideoGameSystemValue system )
    {
        this.system = system;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( String.format( ", System:[%s]", system == null ? "unknown" : system.toString() ) );
        sb.append( series == null ? "" : String.format( ", Series:[%s]", series.toString() ) );
        sb.append( String.format( ", Players:[%d]", players ) );
        sb.append( hasCoop == null ? "" : String.format( " (%s cooperative mode)",
                                                         hasCoop.booleanValue() ? "has" : "does not have" ) );
        sb.append( originalSystem == null ? "" : String.format( ", Original System:[%s]", originalSystem.toString() ) );
        sb.append( compilation == null ? "" : String.format( ", In Compilation:[%s]", compilation.toString() ) );
        sb.append( strategyGuide == null ? "" : String.format( ", Strategy Guide:[%s]",
                                                               strategyGuide.getDd().toString() ) );
        sb.append( copies == 1 ? "" : String.format( ", Have %d copies", copies ) );
        sb.append( String.format( ", %d cartridge", cartridge ? "have" : "no" ) );
        sb.append( Util.isBlank( downloadLocation ) ? "" : String.format( ", Download Location:[%s]",
                                                                          downloadLocation ) );
        sb.append( numberDiscs == null ? "" : String.format( ", Number of Discs:[%d]", numberDiscs.intValue() ) );
        return sb.toString();
    }
}
