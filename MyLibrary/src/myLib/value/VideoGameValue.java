package myLib.value;

import myLib.Util;

/**
 * TODO description
 * 
 * @author knerd.knitter
 */
public class VideoGameValue extends ItemValue
{
    /**
     * TODO description
     * <ul>
     * <li>An enum</li>
     * </ul>
     * 
     * @author knerd.knitter
     */
    public enum Format
    {
     DNLD( "Download" ),
     CART( "Cartridge/Disc" );

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

    private SystemValue          system;
    private VideoGameSeriesValue series;
    private int                  players       = 1;
    private Boolean              hasCoop;
    private SystemValue          originalSystem;
    private VideoGameValue       compilation;
    private boolean              strategyGuide = false;
    private int                  copies;
    private boolean              cartridge;
    private String               downloadLocation;
    private Integer              numberDiscs;

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

    public SystemValue getOriginalSystem()
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

    public SystemValue getSystem()
    {
        return system;
    }

    public boolean isCartridge()
    {
        return cartridge;
    }

    public boolean isStrategyGuide()
    {
        return strategyGuide;
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

    public void setOriginalSystem( SystemValue originalSystem )
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

    public void setStrategyGuide( boolean strategyGuide )
    {
        this.strategyGuide = strategyGuide;
    }

    public void setSystem( SystemValue system )
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
        sb.append( strategyGuide ? ", Have strategy guide" : "" );
        sb.append( copies > 1 ? String.format( ", Have %d copies", copies ) : "" );
        sb.append( String.format( ", %d cartridge", cartridge ? "have" : "no" ) );
        sb.append( Util.isEmpty( downloadLocation ) ? "" : String.format( ", Download Location:[%s]",
                                                                          downloadLocation ) );
        sb.append( numberDiscs == null ? "" : String.format( ", Number of Discs:[%d]", numberDiscs.intValue() ) );
        return sb.toString();
    }
}
