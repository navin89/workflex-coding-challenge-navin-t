import { WorkationTableComponent } from './workation-table.component';

describe('WorkationTableComponent', () => {
  let component: WorkationTableComponent;

  beforeEach(() => {
    component = new WorkationTableComponent(null as any); // pass null or mock service
  });

  describe('getRiskSvg', () => {
    it('returns green SVG for NO', () => {
      expect(component.getRiskSvg('NO')).toBe('assets/green-risk.svg');
    });
    it('returns yellow SVG for LOW', () => {
      expect(component.getRiskSvg('LOW')).toBe('assets/yellow-risk.svg');
    });
    it('returns red SVG for HIGH', () => {
      expect(component.getRiskSvg('HIGH')).toBe('assets/red-risk.svg');
    });
    it('handles lowercase and spaces', () => {
      expect(component.getRiskSvg('  low  ')).toBe('assets/yellow-risk.svg');
    });
  });

  describe('getRiskLabel', () => {
    it('returns "No risk" for NO', () => {
      expect(component.getRiskLabel('NO')).toBe('No risk');
    });
    it('returns "No risk" for LOW', () => {
      expect(component.getRiskLabel('LOW')).toBe('No risk');
    });
    it('returns "High risk" for HIGH', () => {
      expect(component.getRiskLabel('HIGH')).toBe('High risk');
    });
  });

  describe('getRiskClass', () => {
    it('returns "risk-green" for NO', () => {
      expect(component.getRiskClass('NO')).toBe('risk-green');
    });
    it('returns "risk-yellow" for LOW', () => {
      expect(component.getRiskClass('LOW')).toBe('risk-yellow');
    });
    it('returns "risk-red" for HIGH', () => {
      expect(component.getRiskClass('HIGH')).toBe('risk-red');
    });
  });
});
